package ru.coulthard.webpass.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.coulthard.webpass.dto.NoteDto;
import ru.coulthard.webpass.service.NoteService;

import javax.validation.Valid;

@RestController
    @RequestMapping(value = "/passwords")
public class WebPassController {
    private final static String X_HEADER = "X-Pass-User-Id";
    private final NoteService noteService;

    @Autowired
    public WebPassController(NoteService noteService) {
        this.noteService = noteService;
    }

    @PostMapping
    public ResponseEntity<Object> createNote(@Valid @RequestBody NoteDto noteDto,
                                             @RequestParam(value = "resource") String resource,
                                             @RequestParam(value = "generate", required = false, defaultValue = "0") int generateLength,
                                             @RequestHeader(value = X_HEADER) long userId) {
        NoteDto createdNote;
        if (generateLength == 0) {
            createdNote = noteService.createNote(noteDto, resource, userId);
        } else {
            createdNote = noteService.createNoteWithGenerate(noteDto, resource, userId, generateLength);
        }

        return new ResponseEntity<>(createdNote, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Object> findNote(@RequestParam(value = "resource") String resource,
                                           @RequestHeader(value = X_HEADER) long userId) {
        return new ResponseEntity<>(
                noteService.getNote(resource, userId),
                HttpStatus.OK
        );
    }

    @PatchMapping
    public ResponseEntity<Object> updateNote(@Valid @RequestBody NoteDto noteDto,
                                             @RequestParam(value = "resource") String resource,
                                             @RequestParam(value = "generate", required = false) int generateLength,
                                             @RequestHeader(value = X_HEADER) long userId) {
        NoteDto updatedNote;
        if (generateLength == 0) {
            updatedNote = noteService.updateNote(noteDto, resource, userId);
        } else {
            updatedNote = noteService.updateNoteWithGenerate(noteDto, resource, userId, generateLength);
        }

        return new ResponseEntity<>(updatedNote, HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<Object> deleteNote(@RequestParam(value = "resource") String resource,
                                             @RequestHeader(value = X_HEADER) long userId) {
        noteService.deleteNote(resource, userId);
        return ResponseEntity.ok().body(null);
    }
}
