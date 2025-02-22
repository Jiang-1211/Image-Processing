Final Project:圖片濾鏡系統
組員:112610054 江旭宸、112610063 周志鍇

可使用檔案(舉例):
    1  : Pika
    2  : Ania

可使用濾鏡:
   1   : Box Filter(需自行輸入box大小)
   2   : Identity Filter(需自行輸入box大小)
   3   : Median Filter(需自行輸入box大小)
   4   : Contrast Stretching
   5   : Histogram Equalization
   6   : Negative Transformation
   7   : Log Transformation
   8   : Gamma Transformation(需自行輸入gamma值)
   9   : Alpha-Trimmed Mean Filter(需輸入box大小以及想消除的像素數量，想消除得像素數量不得超過box中的總像素數量)
  10   : Laplace
  11   : Sobel
  12   : Motion Blurring(需自行輸入box大小以及模糊方向x或y)

可使用輸出方式:
    1  : Output To .ppm(需自行輸入檔名)
    2  : Low Resolution ASCII Output To Terminal
    3  : Low Resolution ASCII Output To .txt(需自行輸入檔名)
    4  : High Resolution ASCII Output To Terminal
    5  : High Resolution ASCII Output To .txt(需自行輸入檔名)

使用方法:
1.將原始圖片轉檔成P2格式的ppm檔並放到image資料夾中
2.執行main.exe(若是沒有這個檔案則需要打開終端機並使用make指令)
3.終端機會顯示出image資料夾中的所有檔案並加上編號，編號會顯示在檔案名稱前，其格式如同上述【可使用檔案】所示，輸入想處理的檔案的編號並按Enter鍵
4.輸入想使用的濾鏡的編號，其中【可使用濾鏡】的1、2、3、8、9、12項會需要自行輸入相關參數，需輸入的參數如上述【可使用濾鏡】所示，輸入完成後按Enter鍵
5.選擇想使用的輸出方法的編號並按Enter鍵
6.輸出的ppm檔會在image資料夾下，txt檔則會在output資料夾下。輸出完成後會回到【使用方法】1，此時第一張圖片已經處理完，可以繼續處理下一張，若想停止程式則輸入0並按Enter

註:
使用前請確保main.exe的同一層資料夾內有image和output資料夾。
使用【可使用輸出方式】的1、3、5項時會需要自行輸入檔名，輸入時僅需輸入檔案名稱而不用輸入副檔名。檔案名稱若是與現有檔案名稱重複，原始檔案將會被覆蓋。
使用【可使用輸出方式】的2、4項時，請在圖像完全輸出完後再調整字體和視窗大小，以免有破圖的情況發生
使用【可使用輸出方式】的3、5項時，使用txt檔並將字體縮得太小時可能無法正常顯示，切勿一次把字體縮到最小。而有些圖片像素太多，使用txt檔時可能會有自動換行導致格式有誤，右側像素可能跑到左側(至少我的電腦是這樣)

濾鏡功能簡介:
1:將圖片整體變模糊
2:嗯，沒變
3:減少圖片噪點
4:加強圖片對比度
5:改善明亮度分布太集中的圖片
6:將圖片做負片轉換
7:改善太暗的圖片
8:改善太亮或太暗的圖片
9:減少圖片噪點
10:加強圖片邊緣        
11:加強圖片邊緣
12:將圖片沿x方向或y方向做模糊處理