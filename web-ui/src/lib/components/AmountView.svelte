<script lang="ts">
  export let amount: string
</script>

<span class:subdued={amount == "0.00"}>{amount}</span>

<style>
  .subdued {
    opacity: 0.2;
  }
</style>

