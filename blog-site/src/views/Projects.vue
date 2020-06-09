<template>
  <div class="projects">
    <ProjectTable></ProjectTable>
  </div>
</template>

<script>

import ProjectTable from '@/components/ProjectTable.vue'

export default {
  name: 'Projects',
  components: {
    ProjectTable
  }
}

</script>
