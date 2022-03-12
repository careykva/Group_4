- name: CodeCov
        uses: codecov/codecov-action@v2
        with:
          # token: ${{ secrets.CODECOV_TOKEN }} # not required for public repos 
          directory: ./target/site/jacoco
          flags: Integration Tests # optional
          verbose: true # optional (default = false)
