(defproject com.rentpath/rp-json-clj "0.2.3"
  :description "Miscellaneous JSON utilities"
  :url "https://github.com/rentpath/rp-json-clj"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :scm {:url "git@github.com:rentpath/rp-json-clj.git"}
  :deploy-repositories [["releases" {:url "https://clojars.org/repo/"
                                     :username [:gpg :env/CLOJARS_USERNAME]
                                     :password [:gpg :env/CLOJARS_PASSWORD]
                                     :sign-releases false}]]
  :global-vars {*warn-on-reflection* true}
  :profiles {:dev {:dependencies [[org.clojure/clojure "1.9.0-alpha13"]]}})
