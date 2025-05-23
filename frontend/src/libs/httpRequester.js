import axios from "axios";
import {useAccountStore} from "@/stores/account";

const instance = axios.create();

// 서버로 부터 전달된 응답을 axios interceptor 가 가로채서 처리하겠다.
instance.interceptors.response.use((res) => {

    return res;
}, async (err) => {

    switch (err.response.status) {
        case 400:
            window.alert("잘못된 요청입니다.");
            break;

        case  401:
            window.alert("권한이 없습니다.");
            window.location.replace("/");
            break;

        case 500:
            window.alert("관리자에게 문의해 주세요");
            break;
    }

    return Promise.reject(err);
});

//Axios 객체의 메서드를 호출해서 HTTP GET,POST,PUT,DELETE 요청 메서드
export default {
    get(url, params) {

            return instance.get(url, {params});
    },
    post(url, params) {
        return instance.post(url, params);
    },
    put(url, params) {
        return instance.put(url, params);
    },
    delete(url) {
        return instance.delete(url);
    },
};

// (쿠키에 있는) 리프레시 토큰으로 액세스 토큰 요청


// 액세스 토큰


// 계정 스토어


// 계정 스토어의 액세스 토큰 변경


// 요청 액세스 토큰 교체


// 중복 재요청 방지를 위한 프로퍼티 추가

// 재요청


// HTTP 요청 설정 생성




