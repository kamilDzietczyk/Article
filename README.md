# Article

Przed uruchomieniem aplikacji należy utworzyć bazę mysql. Schemat bazy zawarty w pliku Database.txt

POBIERA WSZYSTKIE ARTYKUŁY ORAZ SORTUJE PO DACIE PUBLIKACJI http://localhost:8080/api/Article/GetAll

Pobiera użytkowników po id. W przypadku braku zwraca pustą listę http://localhost:8080/api/Article/GetById/{id}

Pobiera artykuły których Content lub tytuł zawiera tekst z parametru temp http://localhost:8080/api/Article/GetAll/{temp}

Dodaje artykuł http://localhost:8080/api/Article/AddArticle

Podmienia Artykuł po id. W przypadku braku artykułu o id zwraca 'HttpStatus.NOT_FOUND' http://localhost:8080/api/Article/UpdateArticle/{id}

Usuwa artykuł po id. W przypadku braku id zwraca 'HttpStatus.INTERNAL_SERVER_ERROR' http://localhost:8080/api/Article/DeleteArticle/{id}
