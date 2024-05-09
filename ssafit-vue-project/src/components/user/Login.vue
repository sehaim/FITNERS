<template>
  <div id="container">
    <div>로그인</div>
    <form action="">
      <div>
        <label for="id">아이디</label>
        <input type="text" name="id" />
      </div>
      <div>
        <label for="password">비밀번호</label>
        <input type="text" name="password" />
      </div>
      <button type="submit">로그인</button>
    </form>
  </div>
</template>

<style scoped>
#container {
  width: 400px;
  height: 450px;
  background-color: gray;
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: space-between;
  padding-top: 20px;
  padding-bottom: 20px;
}
</style>
