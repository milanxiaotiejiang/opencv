LOCAL_PATH := $(call my-dir)

include $(CLEAR_VARS)


OpenCV_INSTALL_MODULES := on
OpenCV_CAMERA_MODULES := off

OPENCV_LIB_TYPE := SHARED

ifeq ("$(wildcard $(OPENCV_MK_PATH))","")
include ..\..\..\..\native\jni\OpenCV.mk
else
include $(OPENCV_MK_PATH)
endif

LOCAL_MODULE := libdetection_based_tracker

LOCAL_SRC_FILES := org_opencv_facedetect_DetectionBasedTracker.cpp

LOCAL_LDLIBS +=  -lm -llog

include $(BUILD_SHARED_LIBRARY)