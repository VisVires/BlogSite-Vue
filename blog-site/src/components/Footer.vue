<template>
  <div class="footer">
    <footer class="page-footer">
      <b-pagination-nav :link-gen="linkGen" :number-of-pages="5" use-router></b-pagination-nav>
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
  methods: {
    linkGen (pageNum) {
      return pageNum === 1 ? '?' : `?page=${pageNum}`
    }
  }
}
</script>
