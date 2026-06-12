# 📚 Public Information API

API publik untuk menyajikan konten informasi berupa teks, gambar, dan video secara statis berdasarkan kategori dan bahasa.

**Base URL:** `http://localhost:8080` (lokal)

---

## 🚀 Fitur

- ✅ 24 data statis dalam 5 kategori
- ✅ Dukungan multi-bahasa (Indonesia & English)
- ✅ Filter berdasarkan kategori dan bahasa
- ✅ Pagination
- ✅ Endpoint terpisah untuk gambar, video, dan detail
- ✅ CORS enabled (public API)
- ✅ Response format konsisten `{code, status, data}`
- ✅ URL gambar & video dari internet (tidak perlu storage)

---

## 📋 Daftar Endpoint

| Method | Endpoint | Deskripsi |
|--------|----------|-----------|
| GET | `/api/information` | List semua informasi |
| GET | `/api/information/{id}` | Detail informasi by ID |
| GET | `/api/information/{id}/image` | Gambar saja |
| GET | `/api/information/{id}/video` | Video saja |
| GET | `/api/information/{id}/detail` | Teks deskripsi saja |
| GET | `/api/information/images` | List semua gambar |
| GET | `/api/information/videos` | List semua video |
| GET | `/api/categories` | Daftar kategori |
| GET | `/api/languages` | Daftar bahasa |

---

## 📦 Response Format

Semua response menggunakan format:

```json
{
  "code": "number",
  "status": "string",
  "data": "object | array | null"
}