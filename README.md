# Pre-test
- [資料庫測驗](#資料庫測驗)
- [API 實作測驗](#api-實作測驗)
## 資料庫測驗

### 題目一
請寫出一條查詢語句 (SQL)，列出在 2023 年 5 月下訂的訂單，使用台幣付款且5月總金額最
多的前 10 筆的旅宿 ID (bnb_id), 旅宿名稱 (bnb_name), 5 月總金額 (may_amount)

回答：
```sql
SELECT b.id, b.name as bnb_name, sum(o.amount) as may_amount
FROM bnbs b
JOIN orders o
ON o.bnb_id = b.id
WHERE currency = 'TWD'
AND created_at BETWEEN '2023-05-01 00:00:00' AND '2023-05-31 23:59:59'
GROUP BY b.id
ORDER BY sum(o.amount) DESC
LIMIT 10;
```

### 題目二
在題目一的執行下，我們發現 SQL 執行速度很慢，您會怎麼去優化？請闡述您怎麼判斷與優
化的方式

回答：
1. `WHERE` 條件查詢會使用到的欄位，可以加上 index 優化搜尋效率。
2. 可以在查詢的 SQL 前加上 `EXPLAIN` 確認效果，查看 Query 執行時預估掃描的行數。
3. 使用覆蓋索引，將表中的多欄位設定為同一個 index

#### Query效能測試

假設 `orders` table 中共有 127 筆資料，而`orders` table 中符合 2023-05 且使用新台幣支付的訂單共 11 筆。
透過題目一的 Query 搭配 `EXPLAIN` 語法觀察結果。

尚未設置 index
![non-index](https://github.com/joeyliao127/pre_test/blob/main/DB_test/non_index.jpg?raw=true)
全表搜尋，預估查詢 127 行，通過率為 1.11 %

設置 covering index
![covering index](https://github.com/joeyliao127/pre_test/blob/main/DB_test/Covering_index_test.jpg?raw=true)
透過 index 搜尋，預估查詢 11 行，通過率為 100 %

## API 實作測驗

### SOLID 原則

**SRP 單一職責原則**

每一個 class 指負責一項主題，Ex.
- OrderParamsValidationServiceImpl 是和參數驗證相關的 service。
- CurrencyConverterImpl 是專門用於匯率轉換。
- Controller 只負責接收和回應訊息，不會處理數據的轉換與格式驗證。

**OCP 開閉原則**

controller單向呼叫service，未來在修改、擴充程式碼時，可以基於原有的service進行擴充，而不動到原有的程式碼。

**ISP 介面隔離原則**

由於 request body 中的參數需要經過驗證、轉換幣別等流程，因此將 **驗證** 與 **轉換幣別** 拆成兩個 Interface，分別是 `CurrencyConverter` 和 `OrderParamsValidationService`， 避免一個過大的介面，導致其他 class 在調用時，依賴介面中用不到的method。

**DIP反向依賴原則**

`OrdersController` (高層模組) 在調用 `OrderServiceImpl` (低層模組) 時，是依賴於 `OrderService` Interface，而非實作類別。

`OrdersController` 在 constructor 定義建構參數必須有 `OrderService`，透過依賴注入的方式取得實作。

`OrderServiceImpl` 依賴 `OrderParamsValidationServiceImpl` 和 `CurrencyConverterImpl`，因此在`OrderServiceImpl` 的 constructor 定義建構參數 `OrderParamsValidationService` 和 `CurrencyConverter` 參數，透過依賴注入取得實作。

### 設計模式
透過 `CurrencyConverter` 實現策略模式。
未來若有其他幣別需要轉換，如 JPY 轉為 TWD ，只需要新增class 並 implement `CurrencyConverter`介面，即可變換幣別轉換的策略。 

## Docker-compose
將專案 clone 到本地後，執行 `docker-compose up -d --build` 啟動專案，服務運行在 `8080` port。









