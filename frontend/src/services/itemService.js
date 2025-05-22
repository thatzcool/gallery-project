import axios from "axios";

//상품 목록 조회하는 getItems 메서드 : HTTP GET 방식으로 상품 목록 API 호출하고 응답을 리턴하는 기능
export const getItems = () => {
       return axios.get("/v1/api/items").catch(e => e.response);
};


