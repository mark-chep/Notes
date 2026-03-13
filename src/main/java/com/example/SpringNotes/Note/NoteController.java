package com.example.SpringNotes.Note;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RequiredArgsConstructor
@Controller
public class NoteController {
    private final NoteService noteService;

    @GetMapping("/")
    public String index(Authentication authentication) {
        if (authentication != null && authentication.isAuthenticated()) {
            return "redirect:/note/list";
        }
        return "redirect:/login";
    }

    @GetMapping(value = "/note/list" )
    public ModelAndView getList() {
        ModelAndView modelAndView = new ModelAndView("note");
        modelAndView.addObject("notes", noteService.listAll());
        return modelAndView;
    }

    @GetMapping(value = "/note/create")
    public String createNote() {
        return "create-note";
    }

    @PostMapping(value = "/note/create")
    public String create(@ModelAttribute Note note) {
        noteService.add(note);
        return "redirect:/note/list";
    }

    @GetMapping(value = "/note/edit")
    public String editNote(Model model, @RequestParam int id) {
        Note note = noteService.getById(id);
        model.addAttribute("note" , note);
        return "edit-note";
    }

    @PostMapping(value = "/note/edit")
    public String edit(@ModelAttribute Note note) {
        noteService.update(note);
        return "redirect:/note/list";
    }

    @PostMapping("/note/delete")
    public String delete(@RequestParam int id) {
        noteService.deleteById(id);
        return "redirect:/note/list";
    }
}