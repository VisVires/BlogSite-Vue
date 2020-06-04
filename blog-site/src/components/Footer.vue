<template>
  <div class="footer">
    <footer class="page-footer">
      <b-pagination-nav :link-gen="linkGen" :number-of-pages="5" use-router></b-pagination-nav>
    <div class="contact">
      <h4 style="text-align: left"><strong>CONTACT ME</strong></h4>
        <p class="footer"><a href="https://www.linkedin.com/in/georgw1/"> <i class="fa fa-linkedin-square" aria-hidden="true"></i> LinkedIn </a></p>
        <p class="footer"><a href="mailto:wgeorge@outlook.com"> <i class="fa fa-envelope-o" aria-hidden="true"></i> Email </a></p>
        <p class="footer"><a href="https://github.com/VisVires"><i class="fa fa-github-square" aria-hidden="true"></i> GitHub </a></p>
        <p class="footer"><a href="https://instagram.com/visviresvita"><i class="fa fa-instagram" aria-hidden="true"></i> Instagram </a></p>
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
