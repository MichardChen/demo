<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
</head>
<body>
<p>上传图片到mongodb</p>
<form action="/mongo/upload" method="post" enctype="multipart/form-data">
    文件：<input type="file" name="uploadFile"/>
    <input type="submit" value="上传"/>
</form>
<a href="/mongo/downloadFile?file_id=5db83d3ce7bd9b1aeca57c35">file1</a>
<a href="/mongo/downloadFile?file_id=5db7b54d0c83832074d9ca17">file2</a>
</body>
</html>
