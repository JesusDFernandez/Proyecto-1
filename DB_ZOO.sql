PGDMP     +    5                y         	   ZOOLOGICO    13.0    13.0     �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            �           1262    40960 	   ZOOLOGICO    DATABASE     g   CREATE DATABASE "ZOOLOGICO" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'Spanish_Spain.1252';
    DROP DATABASE "ZOOLOGICO";
                postgres    false            �            1259    40982    anfibios    TABLE     �   CREATE TABLE public.anfibios (
    nombrecomun character varying(100) NOT NULL,
    nombrecientifico character varying(100) NOT NULL,
    edad character varying(100) NOT NULL
);
    DROP TABLE public.anfibios;
       public         heap    postgres    false            �            1259    40987    aves    TABLE     �   CREATE TABLE public.aves (
    nombrecomun character varying(100) NOT NULL,
    nombrecientifico character varying(100) NOT NULL,
    edad character varying(100) NOT NULL
);
    DROP TABLE public.aves;
       public         heap    postgres    false            �            1259    40972 	   mamiferos    TABLE     �   CREATE TABLE public.mamiferos (
    nombrecomun character varying(100) NOT NULL,
    nombrecientifico character varying(100) NOT NULL,
    edad character varying(100) NOT NULL
);
    DROP TABLE public.mamiferos;
       public         heap    postgres    false            �            1259    40977    reptiles    TABLE     �   CREATE TABLE public.reptiles (
    nombrecomun character varying(100) NOT NULL,
    nombrecientifico character varying(100) NOT NULL,
    edad character varying(100) NOT NULL
);
    DROP TABLE public.reptiles;
       public         heap    postgres    false            �          0    40982    anfibios 
   TABLE DATA           G   COPY public.anfibios (nombrecomun, nombrecientifico, edad) FROM stdin;
    public          postgres    false    202   �       �          0    40987    aves 
   TABLE DATA           C   COPY public.aves (nombrecomun, nombrecientifico, edad) FROM stdin;
    public          postgres    false    203   �       �          0    40972 	   mamiferos 
   TABLE DATA           H   COPY public.mamiferos (nombrecomun, nombrecientifico, edad) FROM stdin;
    public          postgres    false    200   N       �          0    40977    reptiles 
   TABLE DATA           G   COPY public.reptiles (nombrecomun, nombrecientifico, edad) FROM stdin;
    public          postgres    false    201   �       1           2606    40986    anfibios anfibios_pkey 
   CONSTRAINT     ]   ALTER TABLE ONLY public.anfibios
    ADD CONSTRAINT anfibios_pkey PRIMARY KEY (nombrecomun);
 @   ALTER TABLE ONLY public.anfibios DROP CONSTRAINT anfibios_pkey;
       public            postgres    false    202            3           2606    40991    aves aves_pkey 
   CONSTRAINT     U   ALTER TABLE ONLY public.aves
    ADD CONSTRAINT aves_pkey PRIMARY KEY (nombrecomun);
 8   ALTER TABLE ONLY public.aves DROP CONSTRAINT aves_pkey;
       public            postgres    false    203            -           2606    40976    mamiferos mamiferos_pkey 
   CONSTRAINT     _   ALTER TABLE ONLY public.mamiferos
    ADD CONSTRAINT mamiferos_pkey PRIMARY KEY (nombrecomun);
 B   ALTER TABLE ONLY public.mamiferos DROP CONSTRAINT mamiferos_pkey;
       public            postgres    false    200            /           2606    40981    reptiles reptiles_pkey 
   CONSTRAINT     ]   ALTER TABLE ONLY public.reptiles
    ADD CONSTRAINT reptiles_pkey PRIMARY KEY (nombrecomun);
 @   ALTER TABLE ONLY public.reptiles DROP CONSTRAINT reptiles_pkey;
       public            postgres    false    201            �   P   x�J�KT(�/����,��OJ,I-VH�I���y�Ŝ�\���
)�E�)���yə9���
�E��9�y�ŜF\1z\\\ C�      �   K   x�s>�9/%�H!1/%3/�3�4���H!��� ����Ā˱,������3H�dd�+$'��+pp��qqq |�`      �   H   x��/�W�KM/�WH�M-�LN���-*.-��K�9��|Ro�SpL�*	H�+�H-JT�I��44������ (%�      �   =   x�s�OTH��+.)�L.�/�t���\����)E�9���E feNfJb���W� ��     