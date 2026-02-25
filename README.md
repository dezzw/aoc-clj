# aoc-clj

Leiningen-based Advent of Code project with multi-year layout and Clerk support.

## Layout

```text
src/
  aoc_clj/
    clerk.clj
    2024/
      day01.clj
      day02.clj
      ...
    2025/
      day01.clj
```

Namespace convention:

- `src/aoc_clj/2024/day01.clj` -> `(ns aoc-clj.2024.day01)`

This follows the `klsmithphd/aoc-clj` style while keeping Clerk in the Leiningen workflow.

## Commands

- `lein check`
- `lein clerk-serve`
- `lein clerk-build`

## GitHub Pages

This repo includes [deploy-clerk-pages.yml](.github/workflows/deploy-clerk-pages.yml),
which builds Clerk and deploys `public/build` to GitHub Pages on every push to `main`.
