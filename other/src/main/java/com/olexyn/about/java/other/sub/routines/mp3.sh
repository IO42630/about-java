#!/bin/bash
a=$1
b=${a::-3}mp3
ffmpeg -i $a -codec:a libmp3lame -q:a 0 $b



# LAME Bitrate Overview https://trac.ffmpeg.org/wiki/Encode/MP3
# lame option	Average kbit/s	Bitrate range kbit/s	ffmpeg option
# -b 320	320		320 CBR (non VBR)	-b:a 320k (NB this is 32KB/s, or its max)
# -V 0		245		220-260			-q:a 0 (NB this is VBR from 22 to 26 KB/s)
# -V 1		225		190-250			-q:a 1
# -V 2		190		170-210			-q:a 2
# -V 3		175		150-195			-q:a 3


# -c:a 
# set audio codec