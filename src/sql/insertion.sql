-- INSERTS DE PROFESORES
INSERT INTO profesor (nombre, apellido, tipo) VALUES
      ('Carlos', 'Ramírez', 'TP'),
      ('María', 'Gonzales', 'TC'),
      ('Luis', 'Fernández', 'A'),
      ('Ana', 'Torres', 'TP'),
      ('Diego', 'Castillo', 'TC'),
      ('Lucía', 'Vargas', 'A'),
      ('Jorge', 'Mendoza', 'TP'),
      ('Elena', 'Rojas', 'TC');

-- INSERTS DE CURSOS
INSERT INTO curso (nombre, id_profesor) VALUES
    ('Programación I', 1),
    ('Bases de Datos', 1),
    ('Algoritmos', 2),
    ('Ingeniería de Software', 2),
    ('Matemática Discreta', 3),
    ('Estructuras de Datos', 4),
    ('Desarrollo Web', 4),
    ('Sistemas Operativos', 5),
    ('Inteligencia Artificial', 6),
    ('Redes de Computadoras', 7),
    ('Arquitectura de Computadoras', 7),
    ('Gestión de Proyectos', 8),
    ('Programación 2', NULL);