<template>
  <div class="footer">
    <footer class="page-footer">
      <div class="contact">
      <h4 style="text-align: left"><strong>CONTACT ME</strong></h4>
        <p class="footer">
          <a href="https://www.linkedin.com/in/georgw1/">
          <font-awesome-icon :icon="['fab', 'linkedin']">
          </font-awesome-icon> LinkedIn </a>
        </p>
        <p class="footer">
          <a href="mailto:wgeorge@outlook.com">
          <font-awesome-icon :icon="['far', 'envelope']">
          </font-awesome-icon> Email </a>
        </p>
        <p class="footer">
          <a href="https://github.com/VisVires">
          <font-awesome-icon :icon="['fab', 'github']">
          </font-awesome-icon> GitHub </a>
        </p>
        <p class="footer">
          <a href="https://instagram.com/visviresvita">
          <font-awesome-icon :icon="['fab', 'instagram']">
          </font-awesome-icon> Instagram </a>
        </p>
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
