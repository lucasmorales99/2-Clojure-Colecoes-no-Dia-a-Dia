(ns loja.aula1)
;["daniela" "guilherme" "carlos" "paulo" "lucia" "ana"]
;{"guilhere" 37, "paulo" 39}
;'(1 2 3 4 5)
;[0 1]
;#{}

;map
;reduce
;filter

(map println ["daniela" "guilherme" "carlos" "paulo" "lucia" "ana"]) ;vai te retornar "daniela" "guilherme" "carlos" "paulo" "lucia" "ana"
(println (first ["daniela" "guilherme" "carlos" "paulo" "lucia" "ana"])) ;vai te retornar daniela
(println (rest ["daniela" "guilherme" "carlos" "paulo" "lucia" "ana"])) ;vai te retornar "guilherme" "carlos" "paulo" "lucia" "ana"
(println (rest []))                                         ;vai te retornar ()
(println (next [["daniela" "guilherme" "carlos" "paulo" "lucia" "ana"]])) ;vai que retornar "guilherme" "carlos" "paulo" "lucia" "ana"
(println (next []))                                         ;vai te retornar nil
(println (seq []))                                          ;vaite retornar nil
(println (seq [1 2 3 5]))                                   ;vai printar a sequencia



(defn meu-mapa
  [funcao sequencia]
  (let [primeiro (first sequencia)]
    (funcao primeiro)
    (meu-mapa funcao (rest sequencia))
    ))                                                        ;vai ficar num looping infinito

;(meu-mapa println ["daniela" "guilherme" "carlos" "paulo" "lucia" "ana"])

;mapa com parada
(defn meu-mapa
  [funcao sequencia]
  (let [primeiro (first sequencia)]
    (if primeiro
      (do
        (funcao primeiro)
        (meu-mapa funcao (rest sequencia))))
    ))

(meu-mapa println ["daniela" "guilherme" "carlos" "paulo" "lucia" "ana"])
(meu-mapa println ["daniela" false "carlos" "paulo" "lucia" "ana"]) ;ele para no false


(defn meu-mapa
  [funcao sequencia]
  (let [primeiro (first sequencia)]
    (if (not (nil? primeiro))
      (do
        (funcao primeiro)
        (meu-mapa funcao (rest sequencia))))
    ))

(meu-mapa println ["daniela" "guilherme" "carlos" "paulo" "lucia" "ana"])
(meu-mapa println ["daniela" false "carlos" "paulo" "lucia" "ana"])

;--------------------
;------------

;(meu-mapa println (range 100000))                           ;estora a pilha

(defn meu-mapa
  [funcao sequencia]
  (let [primeiro (first sequencia)]
    (if (not (nil? primeiro))
      (do
        (funcao primeiro)
        (recur funcao (rest sequencia))))
    ))                                                        ; usando recur vc terá uma recursao e não estourara a pilha

(meu-mapa println (range 5000))