<template>
  <div class="footer">
    <footer class="page-footer">
      <div class="contact">
      <h4 style="text-align: left"><strong>CONTACT ME</strong></h4>
        <p class="footer">
          <a href="https://www.linkedin.com/in/georgw1/">
          <font-awesome-icon :icon="['fab', 'linkedin']">
          </font-awesome-icon> LinkedIn </a><br>
          <a href="mailto:wgeorge@outlook.com">
          <font-awesome-icon :icon="['far', 'envelope']">
          </font-awesome-icon> Email </a><br>
          <a href="https://github.com/VisVires">
          <font-awesome-icon :icon="['fab', 'github']">
          </font-awesome-icon> GitHub </a><br>
          <a href="https://instagram.com/visviresvita">
          <font-awesome-icon :icon="['fab', 'instagram']">
          </font-awesome-icon> Instagram </a>
        </p>
        <div style="text-align: right">
          <h5>Created by William George</h5>
          <h6>Powered by Vue.js</h6>
        </div>
      </div>
    </footer>
  </div>
</template>

<script>
export default {
  name: 'Footer',
  data () {
    return {
    }
  }
}
</script>
