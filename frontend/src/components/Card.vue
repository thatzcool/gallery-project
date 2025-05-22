<script setup>
// 핵심 컨텐츠가 들어가는 영역, 내부에는 라우터 뷰를 배치한다.
import {computed} from "vue";
//프로퍼티 객체
const props = defineProps(
    {
      item :{
          id: Number,
          imgPath: String,
          name: String,
          price: Number,
          discountPer : Number
      }
    }
);


// 상품 할인가
// 라우터 객체
// 계정 스토어
// 장바구니에 상품 담기

</script>

<template>
  <div class="card shadow-sm">
<!--상품사진-->
    <span class="img" :style="{backgroundImage:`url(${props.item.imgPath})`}"
      :aria-label="`상품사진(${props.item.name})`"></span>
    <div class="card-body">
      <p class="card-text">
        <!-- 상품 이름 -->
        <span class="me-2" >{{ props.item.name }}</span>
        <!-- 상품 할인율 -->
        <span class="discount badge bg-danger">{{props.item.discountPer}}%</span>
      </p>
      <div class="d-flex justify-content-between align-items-center">
        <button class="btn btn-primary btm-sm" @click="put()">장바구니 담기</button>
        <!-- 상품 정가(숫자 데이터에 3자리마다 쉼표 표기) -->
        <small class="price text-muted">{{ props.item.price.toLocaleString()}}원</small>
        <!-- 상품 할인가 -->
        <small class="real text-danger">{{ }}</small>
      </div>
    </div>
  </div>
</template>

<style lang="scss" scoped>
.card {
  .img {
    display: inline-block;
    width: 100%;
    height: 250px;
    background-size: cover;
    background-position: center;
  }

  .card-body .price {
    text-decoration: line-through;
  }
}
</style>