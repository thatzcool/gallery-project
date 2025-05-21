<script setup>
// 핵심 컨텐츠가 들어가는 영역, 내부에는 라우터 뷰를 배치한다.



// 상품 할인가
// 라우터 객체
// 계정 스토어
// 장바구니에 상품 담기

</script>

<template>
  <div class="card shadow-sm"> <!-- ④ -->

    <div class="card-body">
      <p class="card-text">


        <!-- 상품 이름 -->
        <!-- 상품 할인율 -->
      </p>
      <div class="d-flex justify-content-between align-items-center">

        <!-- 상품 정가(숫자 데이터에 3자리마다 쉼표 표기) -->
        <!-- 상품 할인가 -->

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