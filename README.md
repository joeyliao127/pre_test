# Pre-test
- [資料庫測驗](#資料庫測驗)
- [API 實作測驗](#api-實作測驗)
## 資料庫測驗

問題一
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

問題二
1. 當 `WHERE` 條件後會使用到的欄位，可以加上 index 優化搜尋效率。
2. 可以在查詢的 SQL 前加上 `EXPLAIN` 確認效果，查看 Query 執行時預估掃描的行數。
3. 使用覆蓋索引，將表中的多欄位設定為同一個 index


## API 實作測驗
