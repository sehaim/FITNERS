<template>
  <div>
    <footer id="footer-container">
      <div>
        <img src="@/assets/img/github-icon.png" alt="github-icon" />
        <a href="https://github.com/kgc9007">김기창</a>
      </div>
      <div>
        <img src="@/assets/img/github-icon.png" alt="github-icon" />
        <a href="https://github.com/sehaim">임세하</a>
      </div>

      <div>Copyright &#169; 기세등등 All Rights reserved</div>
    </footer>
  </div>
</template>

<style scoped>
#footer-container {
  height: 70px;
  background-color: rgb(220, 220, 221);
  display: flex;
  flex-direction: row;
  align-items: center;
  justify-content: space-around;
  padding-left: 25%;
  padding-right: 25%;
  font-size: 14px;
}

a {
  color: black;
}

img {
  width: 23px;
  margin-right: 2px;
}
</style>
