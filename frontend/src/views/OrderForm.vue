<script setup>
import {computed, reactive} from "vue";
import {addOrder} from "@/services/orderService";
import {useRouter} from "vue-router";
import {getItems} from "@/services/cartService";

// 라우터 객체


// 반응형 상태


// 최종 결제 금액


// 주문 데이터 제출
const submit = async () => {
  if (!state.form.name?.trim()) {
    window.alert("이름을 입력해주세요.");
    document.getElementById("name")?.focus();
    return;
  } else if (!state.form.address?.trim()) {
    window.alert("주소를 입력해주세요.");
    document.getElementById("address")?.focus();
    return;
  } else if (state.form.payment === 'card') {
    if (!state.form.cardNumber?.trim()) {
      window.alert("카드 번호를 입력해주세요.");
      document.getElementById("cardNum")?.focus();
      return;
    } else if (state.form.cardNumber.length > 16 || parseInt(state.form.cardNumber).toString() !== state.form.cardNumber) {
      window.alert("카드 번호는 16자 이하의 숫자로만 입력해주세요.");
      document.getElementById("cardNum")?.focus();
      return;
    }
  }

   // 결제 수단이 카드가 아니면



};

// 커스텀 생성 훅

</script>

<template>
  <form class="order-form" @submit.prevent="submit">
    <div class="container">
      <div class="py-5 text-center">
        <div class="h4">
          <b>주문하기</b>
        </div>
        <p class="h6 font-lg mt-3">주문 내역을 확인하시고 주문하기 버튼을 클릭해주세요</p>
      </div>
      <div class="row g-5">
        <div class="col-md-5 col-lg-4 order-md-last">
          <div class="mb-3">
            <span class="h5 mb-3 align-middle me-2">
              <b>구입 목록</b>
            </span>
            <span class="badge bg-primary rounded-pill align-middle"></span>
          </div>
          <ul class="items list-group mb-3">
            <li class="p-3 list-group-item d-flex justify-content-between">
              <div>
                <h6 class="my-0"></h6>
              </div>
              <span class="text-muted">

              </span>
            </li>
          </ul>
          <div class="border p-4 bg-light h5 rounded text-center total-price">
            <span>합계 </span>
            <b></b>
          </div>
          <button type="submit"
                  class="w-100 btn btn-primary py-4 mt-4">결제하기</button>
        </div>
        <div class="col-md-7 col-lg-8">
          <div class="h5 mb-3">
            <b>주문자 정보</b>
          </div>
          <div class="row g-3">
            <div class="col-12">
              <label for="name" class="form-label">이름</label>
              <input type="text" class="form-control p-3" id="name" />
            </div>
            <div class="col-12 pt-1">
              <label for="address" class="form-label">주소</label>
              <input type="text" class="form-control p-3" id="address" />
            </div>
          </div>
          <div class="h5 mt-5 mb-3">
            <b>결제 수단</b>
          </div>
          <div class="my-3">
            <div class="form-check">
              <input id="card" name="paymentMethod" type="radio" class="form-check-input" value="card" >
              <label class="form-check-label" for="card">신용카드</label>
            </div>
            <div class="form-check">
              <input id="bank" name="paymentMethod" type="radio" class="form-check-input" value="bank" >
              <label class="form-check-label" for="bank">무통장입금</label>
            </div>
          </div>
          <div class="pt-1" >
            <label for="cardNum" class="form-label">카드 번호</label>
            <input type="text" class="form-control p-3" id="cardNum" >
          </div>
        </div>
      </div>
    </div>
  </form>
</template>