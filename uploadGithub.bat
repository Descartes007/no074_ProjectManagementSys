set "parent_folder_name="
for %%i in ("%~dp0.") do set "parent_folder_name=%%~nxi"

git init && git add . && git commit -m "first commit" && git branch -M main && git remote add origin git@github.com:Descartes007/%parent_folder_name%.git && git push -u origin main & powershell -c (New-Object Media.SoundPlayer "D:\BaiduNetdiskDownload\dev\upload\finish.wav").PlaySync();

pause