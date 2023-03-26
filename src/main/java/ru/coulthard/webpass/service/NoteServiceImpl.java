package ru.coulthard.webpass.service;

import org.springframework.stereotype.Service;
import ru.coulthard.webpass.dto.NoteDto;

@Service
public class NoteServiceImpl implements NoteService {
    @Override
    public NoteDto createNote(NoteDto noteDto, String resource, long userId) {
        return null;
    }

    @Override
    public NoteDto createNoteWithGenerate(NoteDto noteDto, String resource, long userId, int generateLength) {
        return null;
    }

    @Override
    public NoteDto updateNote(NoteDto noteDto, String resource, long userId) {
        return null;
    }

    @Override
    public NoteDto updateNoteWithGenerate(NoteDto noteDto, String resource, long userId, int generateLength) {
        return null;
    }

    @Override
    public NoteDto deleteNote(String resource, long userId) {
        return null;
    }

    @Override
    public NoteDto getNote(String resource, long userId) {
        return null;
    }
}
