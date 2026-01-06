package com.example.Library.mapper;

import com.example.Library.dto.response.ReaderDto;
import com.example.Library.model.Reader;

public class ReaderMapper{
    public static ReaderDto readerDto(Reader reader){
        return new ReaderDto(reader.getFullName(), reader.getEmail());
    }
}
