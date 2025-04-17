(ns App
  (:require
   ["xstream$default" :as xs]
   ["@cycle/run" :refer [run]]
   ["@cycle/dom" :refer [makeDOMDriver div input p]]))

(defn main [sources]
  {:DOM (-> sources.DOM
            (.select "input")
            (.events "change")
            (.map #(-> % .-target .-checked))
            (.startWith false)
            (.map #(div [(input {:attrs {:type "checkbox"}})
                         "Toggle Me"
                         (p (if % "on" "off"))])))})

(run main {:DOM (makeDOMDriver "#mount")})
