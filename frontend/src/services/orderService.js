import httpRequester from "@/libs/httpRequester";

// 주문 페이지에서 활용할 주문 서비스 코드 입니다.
// 해당 서비스는 백엔드API를 호출해서 주문데이터를 처리하는 기능을 제공하고, 주문 입력 페이지에서도 활용됩니다.


// 주문 삽입
export const addOrder = (args) => {
    return httpRequester.post("/v1/api/orders", args).catch(e => e.response);
};

// 주문 목록 조회
export const getOrders = (args) => {
    return httpRequester.get("/v1/api/orders", args).catch(e => e.response);
}

// 주문 상세 조회
export const getOrder = (id) => {
    return httpRequester.get(`/v1/api/orders/${id}`).catch(e => e.response);
};