import axios from "axios";

//회원 가입 join 메서드 : 회원 가입을 처리하는 메서드, Http POST 메서드로 회원가입API를 호출하고 응답 값을 리턴한다.

  export const join = (args) => {
       return axios.post("/v1/api/account/join",args).catch(e=> e.response);
  };


//로그인 메서드 : 로그인을 처리하는 메서드. HTTP POST 메서드로 로그인 API를 호출하고 응답값을 리턴한다.
   export  const login = (args) =>{
       return axios.post("/v1/api/account/login", args).catch( e => e.response);
   };

 // 로그인 여부 확인
export  const check = () =>{
    return axios.get("/v1/api/account/check").catch( e => e.response);
};


// 로그아웃
export  const logout = (args) =>{
    return axios.post("/v1/api/account/logout", args).catch( e => e.response);
};