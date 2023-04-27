package org.example.service;

import org.example.entity.Reader;

import java.util.List;

public interface ReaderService {
    Reader saveReader(Reader reader);
    String updateReader(Long id,Reader newReader);
    Reader getReaderByBookId(Long bookId);
    void deleteReaderById(Long id);
    List<Reader> getReadersByAuthorId(Long authorId);
}
