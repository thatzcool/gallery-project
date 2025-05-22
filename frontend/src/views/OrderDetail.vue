<script setup>


// 라우트 객체


// 반응형 상태


// 커스텀 생성 훅

</script>

<template>
  <div class="order-detail py-5">
    <div class="container">
      <div class="row">
        <div class="order col-lg-8">
          <div class="h5 mb-4">
            <b>주문 내용</b>
          </div>
          <table class="table table-bordered">
            <tbody>
            <tr>
              <th>주문 ID</th>
              <td></td>
            </tr>
            <tr>
              <th>주문자명</th>
              <td></td>
            </tr>
            <tr>
              <th>주소</th>
              <td></td>
            </tr>
            <tr>
              <th>결제 금액</th>
              <td></td>
            </tr>
            <tr>
              <th>결제 수단</th>
              <td></td>
            </tr>
            <tr>
              <th>결제 일시</th>
              <td></td>
            </tr>
            </tbody>
          </table>
        </div>
        <div class="items col-lg-4">
          <div class="h5 mb-4">
            <b>주문 상품</b>
          </div>
          <table class="table table-bordered">
            <thead>
            <tr>
              <th>번호</th>
              <th>상품명</th>
            </tr>
            </thead>
            <tbody>
            <tr>
              <td></td>
              <td></td>
            </tr>
            </tbody>
            <tfoot>
            </tfoot>
          </table>
        </div>
      </div>
    </div>
  </div>
</template>

<style lang="scss" scoped>
.order-detail {
  > .container {
    table {
      th, td {
        padding: 15px 25px;
      }

      th {
        background: #f7f7f7;
      }
    }
  }
}
</style>