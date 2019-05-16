# Springboot Rest API upload Videos + compress

Springboot2 upload video then compress to lower using [ffmpeg](https://github.com/bramp/ffmpeg-cli-wrapper) libraries.

## Getting Started

System required 

- Java 8
- [ffmpeg](https://ffmpeg.org/download.html)
- maven

## Example request

```bash
curl -X POST \
  http://localhost:8080/upload-video/api/media/upload/video \
  -H 'Content-Type: application/octet-stream' \
  -H 'content-type: multipart/form-data; boundary=----WebKitFormBoundary7MA4YWxkTrZu0gW' \
  -F 'content=@[path-to/file-name.video]'
```
