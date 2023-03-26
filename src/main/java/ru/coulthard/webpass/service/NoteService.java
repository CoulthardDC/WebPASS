package ru.coulthard.webpass.service;

import ru.coulthard.webpass.dto.NoteDto;

public interface NoteService {
    NoteDto createNote(NoteDto noteDto, String resource, long userId);

    NoteDto createNoteWithGenerate(NoteDto noteDto, String resource, long userId, int generateLength);

    NoteDto getNote(String resource, long userId);

    NoteDto updateNote(NoteDto noteDto, String resource, long userId);

    NoteDto updateNoteWithGenerate(NoteDto noteDto, String resource, long userId, int generateLength);

    NoteDto deleteNote(String resource, long userId);
}
