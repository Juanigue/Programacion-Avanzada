extends MeshInstance3D

# Velocidades ajustables que aparecerán en el Inspector de la derecha
@export var velocidad_rotacion : float = 2.0
@export var velocidad_movimiento : float = 5.0

func _process(delta: float) -> void:
	# --- 1. LÓGICA DE ROTACIÓN (Flechas del teclado) ---
	var rot_x = 0.0
	var rot_y = 0.0
	
	if Input.is_action_pressed("rotar_arriba"):
		rot_x -= 1.0
	if Input.is_action_pressed("rotar_abajo"):
		rot_x += 1.0
	if Input.is_action_pressed("rotar_izquierda"):
		rot_y -= 1.0
	if Input.is_action_pressed("rotar_derecha"):
		rot_y += 1.0
		
	# Aplicamos la rotación multiplicada por el tiempo transcurrido (delta)
	rotate_x(rot_x * velocidad_rotacion * delta)
	rotate_y(rot_y * velocidad_rotacion * delta)

	# --- 2. LÓGICA DE TRASLACIÓN (Teclas W, A, S, D, Q, E) ---
	var direccion = Vector3.ZERO
	
	if Input.is_action_pressed("mover_derecha"):    # Tecla D (Horizontal +)
		direccion.x += 1.0
	if Input.is_action_pressed("mover_izquierda"):  # Tecla A (Horizontal -)
		direccion.x -= 1.0
	if Input.is_action_pressed("mover_adelante"):   # Tecla W (Profundidad -)
		direccion.z -= 1.0
	if Input.is_action_pressed("mover_atras"):      # Tecla S (Profundidad +)
		direccion.z += 1.0
	if Input.is_action_pressed("mover_arriba"):     # Tecla Q (Altura +)
		direccion.y += 1.0
	if Input.is_action_pressed("mover_abajo"):      # Tecla E (Altura -)
		direccion.y -= 1.0

	# Si se está presionando alguna tecla, normalizamos el vector 
	# para que no se mueva más rápido cuando va en diagonal.
	if direccion.length() > 0:
		direccion = direccion.normalized()
		
	# Movemos el cubo en el espacio global
	global_translate(direccion * velocidad_movimiento * delta)
