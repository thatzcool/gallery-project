<script setup>

// 반응형 상태


// 장바구니 상품 조회


// 장바구니 상품 삭제


// 커스텀 생성 훅

</script>

<template>
  <div class="cart">
    <div class="container">
      <template>
        <ul class="items">
          <li>
            <img/>
            <b class="name"></b>
            <span class="price">
          원
          </span>
            <span class="remove float-end" title="삭제">&times;</span>
          </li>
        </ul>
        <div class="act">

        </div>
      </template>
      <div class="text-center py-5" >장바구니가 비어있습니다.</div>
    </div>
  </div>
</template>

<style lang="scss" scoped>
.cart {
  .items {
    list-style: none;
    margin: 0;
    padding: 0;

    li {
      border: 1px solid #eee;
      margin-top: 25px;
      margin-bottom: 25px;
    }

    img {
      width: 150px;
      height: 150px;
    }

    .name {
      margin-left: 25px;
    }

    .price {
      margin-left: 25px;
    }

    .remove {
      cursor: pointer;
      font-size: 30px;
      padding: 5px 15px;
    }
  }

  .act .btn {
    width: 300px;
    display: block;
    margin: 0 auto;
    padding: 30px 50px;
    font-size: 20px;
  }
}
</style>