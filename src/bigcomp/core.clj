(ns bigcomp.core
  (:require [clojure.java.io :as io]
            [clojure.edn :as edn]))

(def path (io/resource "config.edn"))
(def m (-> path slurp edn/read-string))

;;heh, this is a janky way to get it working too...
(println *compile-files*)
(if *compile-files*
  (binding [*compile-files* false]
    (def skippedm (binding [*ns* *ns*]
                    (require 'bigcomp.skipped)
                    (-> (resolve 'bigcomp.skipped/m)
                        deref))))
  (def skippedm (do (require 'bigcomp.skipped)
                    (-> (resolve 'bigcomp.skipped/m)
                        deref))))

(println [(= m skippedm)])

