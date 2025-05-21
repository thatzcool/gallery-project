<script setup>
import Header from "@/components/Header.vue";
import Footer from "@/components/Footer.vue";
import {useAccountStore} from "@/stores/account.js";
import {watch} from "vue";
import {useRoute} from "vue-router";
import {check} from "@/services/accountService"

// 계정 스토어
const accountStore = useAccountStore();

// 라우트 객체
const route = useRoute();

// 로그인 여부를 확인하는 체크 메서드 , 계정서비스의 check메서드를 호출해서 로그인 여부를 확인 후, 해당 값으로 계정 스토어 객체를 수정한다.
const checkAccount = async () => {
  const res = await check();

  if (res.status === 200) {
    accountStore.setChecked(true);
    accountStore.setLoggedIn(res.data === true);
  } else {
    accountStore.setChecked(false);
  }
};

// 커스텀 생성 훅
(async function onCreated() {
  await checkAccount();
})();
// 라우트 경로가 바뀔 때마다 로그인 여부를 확인
watch(() => route.path, () => {
  checkAccount();
});

</script>
<template>
  <!-- 로그인 체크 여부 확인 후 출력-->
  <template v-if="accountStore.checked">
    <Header/>
    <main>
      <!-- 라우터 뷰 url 경로에 따라 동적으로 컨텐츠가 바뀔 수 있는 요소를 배치한다.-->
      <router-view></router-view>
    </main>
    <Footer/>
  </template>
</template>