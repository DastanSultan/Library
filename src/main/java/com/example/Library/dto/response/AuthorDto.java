    package com.example.Library.dto.response;

    import java.util.ArrayList;
    import java.util.List;

    public class AuthorDto{
        private String fullName;
        private String email;
        private List<BookDto> booksDto = new ArrayList<>();

        public AuthorDto(String fullName, String email, List<BookDto> booksDto){
            this.fullName = fullName;
            this.email = email;
            this.booksDto = booksDto;
        }
        public String getFullName( ){
            return fullName;
        }

        public String getEmail( ){
            return email;
        }

        public List<BookDto> getBooksDto( ){
            return booksDto;
        }
    }
