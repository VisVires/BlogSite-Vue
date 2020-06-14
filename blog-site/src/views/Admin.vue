<template>
  <div class="admin">
    <div class="blog-header">
      <h1 style="text-align: left" class="blog-title"><strong>Blog Input</strong></h1>
      <p class="lead blog-description">Just a place to easily update and preview changes to my site!</p>
      <hr class="style3">
    </div>
    <b-card no-body>
      <b-tabs card>
        <b-tab title="Add Blog Post" active>
          <BlogForm/>
        </b-tab>
        <b-tab title="Add Quote">
          <QuoteForm/>
        </b-tab>
        <b-tab title="Add Project">
          <ProjectForm/>
        </b-tab>
      </b-tabs>
    </b-card>
    <br>
  </div>
</template>

<script>

import BlogForm from '@/components/BlogForm.vue'
import QuoteForm from '@/components/QuoteForm.vue'
import ProjectForm from '@/components/ProjectForm.vue'

export default {
  name: 'Admin',
  components: {
    BlogForm,
    QuoteForm,
    ProjectForm
  }
}
</script>