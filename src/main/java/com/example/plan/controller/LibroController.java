package com.example.plan.controller;

import com.example.plan.entity.Libro;
import com.example.plan.serviceImpl.AutorService;
import com.example.plan.serviceImpl.EditorialService;
import com.example.plan.serviceImpl.LibroService;
import com.example.plan.util.reportes.LibroExporterExcel;
import com.example.plan.util.reportes.LibroExporterPDF;
import com.lowagie.text.DocumentException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author admin
 */
@Controller
@RequestMapping("/libro")
public class LibroController {

    @Autowired
    private LibroService libroService;
    @Autowired
    private EditorialService editorialService;
    @Autowired
    private AutorService autorService;

    @GetMapping
    public String indexLibro(Model model, @AuthenticationPrincipal User user) {
        model.addAttribute("libros", libroService.readAll());
        return "libros/listarLibro";
    }

    @GetMapping("/add")
    public String addLibro(Model model) {
        model.addAttribute("titulo", "Registrar");
        model.addAttribute("libro", new Libro());
        model.addAttribute("editoriales", editorialService.readAll());
        model.addAttribute("autores", autorService.readAll());
        return "libros/addLibro";
    }

    @GetMapping("/save")
    public String saveLibro(Model model) {
        model.addAttribute("titulo", "Registrar");
        model.addAttribute("libro", new Libro());
        return "libros/addLibro";
    }

    @PostMapping("/save")
    public String addLibro(@Valid @ModelAttribute Libro libro, BindingResult result, Model model, @RequestParam("imagen") MultipartFile imagen, RedirectAttributes attributes) {

        if (!imagen.isEmpty()) {
            //Path dirimg = Paths.get("src//main//resources//static/images");
            String ruta = "E://recursos//images//files2";
            //String ruta = dirimg.toFile().getAbsolutePath();
            //String ruta = "E://recursos//images//autor";

            try {
                byte[] bytesImg = imagen.getBytes();
                Path rutacompleta = Paths.get(ruta + "//" + imagen.getOriginalFilename());
                Files.write(rutacompleta, bytesImg);
                libro.setImagen(imagen.getOriginalFilename());
                libroService.create(libro);
            } catch (IOException e) {
                System.out.println("Error: " + e);
            }
        }
        return "redirect:/libro";
    }

    @GetMapping("/edit/{id}")
    public String editarLibro(@PathVariable("id") int idlibro, Model model) {
        Libro libro = libroService.read(idlibro);
        model.addAttribute("titulo", "Editar");
        model.addAttribute("libro", libro);
        model.addAttribute("editoriales", editorialService.readAll());
        model.addAttribute("autores", autorService.readAll());
        return "libros/addLibro";
    }

    @GetMapping("/detalle/{id}")
    public String detalleLibro(@PathVariable("id") int idlibro, Model model) {

        Libro libro = libroService.read(idlibro);
        model.addAttribute("titulo", "Detalle");
        model.addAttribute("libro", libro);
        return "libros/detalleLibro";
    }

    @GetMapping("/delete/{id}")
    public String deleteLibro(@PathVariable("id") int idlibro) {
        libroService.delete(idlibro);
        return "redirect:/libro";
    }

    @GetMapping("/exportarPDF")
    public void exportarListadoDeEmpleadosEnPDF(HttpServletResponse response) throws DocumentException, IOException {
        response.setContentType("application/pdf");

        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String fechaActual = dateFormatter.format(new Date());

        String cabecera = "Content-Disposition";
        String valor = "attachment; filename=Libros_" + fechaActual + ".pdf";

        response.setHeader(cabecera, valor);

        List<Libro> libros = libroService.readAll();

        LibroExporterPDF exporter = new LibroExporterPDF(libros);
        exporter.exportar(response);
    }

    @GetMapping("/exportarExcel")
    public void exportarListadoDeEmpleadosEnExcel(HttpServletResponse response) throws DocumentException, IOException {
        response.setContentType("application/octet-stream");

        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String fechaActual = dateFormatter.format(new Date());

        String cabecera = "Content-Disposition";
        String valor = "attachment; filename=Libro_" + fechaActual + ".xlsx";

        response.setHeader(cabecera, valor);

        List<Libro> libros = libroService.readAll();

        LibroExporterExcel exporter = new LibroExporterExcel(libros);
        exporter.exportar(response);
    }
}
