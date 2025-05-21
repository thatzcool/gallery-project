<!--회원가입 페이지 (화면)-->
<script setup>
import {reactive} from "vue";
import {join} from "@/services/accountService";
import {useRouter} from "vue-router";

//반응형 상태
const state = reactive({
  form: {
    name: "",
    loginId: "",
    loginPw: "",
  }
});

//라우터 객체
const router = useRouter();

//회원 가입 데이터 백엔드에 제출
const submit = async () => {
  // join api에 데이터를 전달
  const res = await join(state.form);

  //응답 처리
  if (res.status === 200) {
    window.alert("회원가입 완료!!");
    await router.push("/");   // home 으로 리다이렉트
  }
}
</script>


<template>
  <div class="join">
    <div class="container">
      <form class="py-5 d-flex flex-column gap-3" @submit.prevent="submit">
        <h1 class="h5 mb-3">회원가입</h1>
        <div class="form-floating">
          <input type="text" class="form-control" id="name" placeholder="이름" v-model="state.form.name">
          <label for="name">이름</label>
        </div>

        <div class="form-floating">
          <input type="email" class="form-control" id="loginId" placeholder="이메일" v-model="state.form.loginId">
          <label for="name">이메일</label>
        </div>

          <div class="form-floating">
            <input type="password" class="form-control" id="loginPw" placeholder="비밀번호" v-model="state.form.loginPw">
            <label for="name">비밀번호</label>
          </div>
          <button type="submit" class="w-100 h6 btn py-3 btn-primary">회원가입</button>
      </form>
    </div>
  </div>
</template>


<style lang="scss" scoped>
 .join > .container {
   max-width : 600px;
 }
</style>