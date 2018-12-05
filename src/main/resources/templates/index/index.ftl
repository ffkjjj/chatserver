<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>主页</title>
<#--    <style type="text/css">
    </script>-->
</head>
<body>
${(book.bookname)!}
${(book.charptername)!}
${(book.bookcontent)!}
<button id="nextpage" onclick="nextPage()" value="next" style="zoom: 300%">
    <script>
        function nextPage() {
            index = ${(book.index)!};
            window.location.href = "https://myll.ml/book?index=" + (index + 1);
        }
    </script>
</body>
</html>