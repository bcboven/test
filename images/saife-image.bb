SUMMARY = "A console development image with some C/C++ dev tools"
HOMEPAGE = "http://www.jumpnowtek.com"
LICENSE = "MIT"

IMAGE_FEATURES += "package-management"
IMAGE_LINGUAS = "en-us"

inherit core-image

CORE_OS = " \
    busybox-hwclock \
    openssh openssh-keygen openssh-sftp-server \
    tzdata \
 "


DEV_EXTRAS = " \
    ntp \
    ntp-tickadj \
 "

EXTRA_TOOLS_INSTALL = " \
    bzip2 \
    findutils \
    i2c-tools \
    less \
    nano \
    sysfsutils \
    tcpdump \
    unzip \
    wget \
    zip \
    python-modules \
    python-dev \
    iptables \
    dnsmasq \
    sudo \
    nginx \
    curl \
 "

IMAGE_INSTALL += " \
    ${CORE_OS} \
    ${DEV_EXTRAS} \
    ${EXTRA_TOOLS_INSTALL} \
 "

set_local_timezone() {
    ln -sf /usr/share/zoneinfo/EST5EDT ${IMAGE_ROOTFS}/etc/localtime
}

disable_bootlogd() {
    echo BOOTLOGD_ENABLE=no > ${IMAGE_ROOTFS}/etc/default/bootlogd
}

ROOTFS_POSTPROCESS_COMMAND += " \
    set_local_timezone ; \
    disable_bootlogd ; \
 "

export IMAGE_BASENAME = "saife-image"

