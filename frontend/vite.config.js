import { fileURLToPath, URL } from 'node:url'
import { defineConfig } from 'vite'
import vue from '@vitejs/plugin-vue'

// https://vitejs.dev/config/
export default defineConfig({
   server:{

      proxy: {
            "/v1/api" : {
                 target: "http://localhost:8080",
                 changeOrigin: true
            }
      }

   },


  plugins: [
    vue(),
  ],
  resolve: {
    alias: {
      '@': fileURLToPath(new URL('./src', import.meta.url))
    }
  }
})


// 3. CORS(Cross-Origin Resouce Sharing)
// 클라이언트와 서버의 URL  http://localhost  포트가(5173,8080) 서로 다르기 때문에
//     CORS(Cross-Origin Resouce Sharing) 문제가 발생함.
//     서버 객체에 proxy를 추가한다.