<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>主页</title>
</head>
<body>
<div id="app">
    ${(book.bookname)!}
    ${(book.charptername)!}
    <br>
    <input value="${index}" onchange="changePage(this)">
    <br>
    ${(book.bookcontent)!}
    <button id="nextPage" onclick="nextPage()" style="zoom: 150%;">next</button>
</div>
<script>
    function nextPage() {
        window.location.href= "/book/book?index=${(index!1) + 1}&bookid=${(bookid)}"
        scrollTo(0, 0);
    }
    
    function changePage(event) {
        window.location.href= "/book/book?index=" + event.value +"&bookid=${(bookid)}"
    }
</script>
</body>
</html>