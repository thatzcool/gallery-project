import { fileURLToPath, URL } from 'node:url'
import { defineConfig } from 'vite'
import vue from '@vitejs/plugin-vue'

// https://vitejs.dev/config/
export default defineConfig({
    // server.proxy : 프록시 설정 부분
   server:{

      proxy: {
            "/v1/api" : {
                 target: "http://localhost:8080",
                 changeOrigin: true,
                 // rewrite: (path) => path.replace(/^\/api/,''),
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
// 프론트와 백을 독립적으로 구성하고 경로에 대한 충돌없이 연결할 수 있다.
// 1. CORS 에러 방지
// 2. 실제 백엔드 주소를 숨기고 개발용 주소로 통일할 수 있음
// 3. 동일 출처 정책 우회
// 4. 코드 배포 전까지 프론트와 백을 완전히 분리해서 구현할 수 있다.

// ---CROS => 웹 브라우저에서 보안상 적용하는 정책
//
// 같은 출처 = 프로토콜 + 도메인 + 포트
// 웹브라우저
//
// proxy server : 중간에 요청을 전달해 주는 서버
//
// http://localhost:5173  프로트엔드
//
//     http://localhost:8080   백엔드
//
//         프론트엔드  => 같은 출처의 proxy 서버에 요청을 전달한다.
// => 프록시 서버는 백엔드 서버에 요청을 대신 전달
//     => 응답을 받아 프론트엔드 다시 전달
//
// 브라우저 => http://localhost:5173/api/account/check 요청
// 프록시 서버가 http://locahost:8080/api/account/check  요청을 대신 보냄
//     백엔드 서버가 응답을 프록시 서버에 전달
// 프록시 서버가 브라우저에 응답 전달
// 브라우저 는 같은 출처 요청으로 간주되므로 CORS 정책을 우회
//
//
// CORS : 브라우저의 보안 정책, 다른 출처에 대한 요청을 제한
// Proxy : 클라이언트 대신 백엔드서버에  요청을 전달해주는 중간 서버
// CORS 에러를 우회하여 같은 출처처럼 요청을 보내게 하는 역할