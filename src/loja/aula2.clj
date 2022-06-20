(ns loja.aula2)

; ["daniela" "guilherme" "carlos" "paulo" "lucia" "ana"]

(defn conta
  [total-até-agora elementos]
  (recur (inc total-até-agora) (rest elementos))
  )                                                         ;da erro

(defn conta
  [total-ate-agora elementos]
  (if (next elementos)
    (recur (inc total-ate-agora) (next elementos))))

(println (conta 0 ["daniela" "guilherme" "carlos" "paulo" "lucia" "ana"]))

(defn conta
  [total-ate-agora elementos]
  (println total-ate-agora elementos)
  (if (next elementos)
    (recur (inc total-ate-agora) (next elementos))
    (inc total-ate-agora)))

(println (conta 0  ["daniela" "guilherme" "carlos" "paulo" "lucia" "ana"]))
(println (conta 0 []))                                      ;essa maneira não trata vetres vazios


;-------------- com tratamento de vetor vazio
(defn conta
  [total-ate-agora elementos]
  (println total-ate-agora elementos)
  (if (seq elementos)
    (recur (inc total-ate-agora) (next elementos))
   total-ate-agora))

(println (conta 0  ["daniela" "guilherme" "carlos" "paulo" "lucia" "ana"]))
(println (conta 0 []))


;--------------------
;VARIAÇÕES DA FUNÇÃO
;-------------

(defn minha-funcao
  ([parametro1] (println "p1" parametro1))
  ([parametro1 parametro2] (println "p2" parametro1 parametro2)))
(minha-funcao 1)
(minha-funcao 1 2)


(defn conta
  ([elementos]
   (conta 0 elementos))

  ([total-ate-agora elementos]
   (println total-ate-agora elementos)
   (if (seq elementos)
     (recur (inc total-ate-agora) (next elementos))
     total-ate-agora)))

(println (conta 0  ["daniela" "guilherme" "carlos" "paulo" "lucia" "ana"]))
(println (conta 0 []))



;-------------------Loop e sua desvantagem
; for total-ate-agora 0, elementos-restantes elementos; 1 next
(defn conta
  [elementos]
  (loop [total-ate-agora 0
         elementos-restantes elementos]
    (if (seq elementos-restantes)
      (recur (inc total-ate-agora) (next elementos-restantes))
      total-ate-agora)))

(println (conta ["daniela" "guilherme" "carlos" "paulo" "lucia" "ana"]))
(println (conta []))

(println (conta ["daniela" "guilherme" "carlos" "paulo" "lucia" "ana"]))
(println (conta []))